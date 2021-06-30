import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getTop10() {
    return this.http.get<any>(`${environment.urlApiRest}/players/topTen`)
      .pipe(map((resp : any) => {
        return resp;
      }));
  }
}
