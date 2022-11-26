export class QuizCollectionUpdateReqDto {
    private id! : number
    private score! : number
    private ver! : number
    private isActive! : boolean

    public get _score(): number {
        return this.score;
    }

    public set _score(_score: number) {
        this.score = _score;
    }
    
    public get _isActive(): boolean {
        return this.isActive;
    }

    public set _isActive(_isActive: boolean) {
        this.isActive = _isActive;
    }

    public get _id(): number {
        return this.id;
    }

    public set _id(_id: number) {
        this.id = _id;
    }

    public get _ver(): number {
        return this.ver;
    }

    public set _ver(_ver: number) {
        this.ver = _ver;
    }
    
}