export class Stat {
    creationDateTime: Date;
    id: Number;
    score: Number;

    constructor(id: Number, creationDateTime: Date, score: Number) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.score = score;
    }
}