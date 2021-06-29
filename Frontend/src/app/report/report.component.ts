import { OnDestroy } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { ColumnMode, SelectionType, SortType } from '@swimlane/ngx-datatable';
import { throwError } from 'rxjs';
import { Player } from '../models/player.model';
import { PlayerService } from '../services/player.service';
import { ReportService } from '../services/report.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit, OnDestroy {

  expanded: any = {};
  timeout: any;
  players: Player[] = [];
  lastTimeUpdated: Date | undefined;
  ColumnMode = ColumnMode;
  SortType = SortType;
  loadingIndicator = true;
  SelectionType = SelectionType;
  private columns: string [] = ["nickname", "img_url", "score"]
  private csvFooter: {} | undefined;
  private intervalId: any;

  constructor(private playerService: PlayerService, private reportService: ReportService) { }

  ngOnInit(): void {
    this.getTop10();
    this.intervalId = setInterval(() => {
      this.getTop10();
    }, 10000);
  }

  getTop10() {
    this.playerService.getTop10()
      .subscribe(players => {
        this.players = players.player;
        this.lastTimeUpdated = players.lastTimeUpdated;
        
      }, err => {
        throwError('Error Occurred. Code: ' + err.status);
      });
  }
  ngOnDestroy(): void {
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
  }

  exportReport(): void {
    let obj = this.prepareDataToExport(this.players)
    this.reportService.exportReportToCsv(obj, 'position-table', this.columns, `Last time updated,${this.lastTimeUpdated}` ) ;
  }

  prepareDataToExport(players: Player[]): object[]{
    let obj: object[] = [];
    players.forEach(elem=>{
      obj.push(
        {'nickname': elem.nickname, 'img_url': elem.image, 'score': elem.stat.score}
      );
    });
    return obj;
  }
}
