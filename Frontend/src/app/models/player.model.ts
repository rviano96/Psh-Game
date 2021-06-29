import { Stat } from "./stat.model";

export class Player {
    creationDateTime: Date;
    id: Number;
    image: String;
    nickname: String;
    stat: Stat;
    constructor(id: Number, creationDateTime: Date, image: String, nickname: String, stat: Stat) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.image = image;
        this.nickname = nickname;
        this.stat = stat;
    }
}