export class QuizScheduleDataDto{

    private _id! : number
	private _startTime! : string
	private _endTime! : string
	private _quizId! : number
	private _quizCode! : string
	private _quizSubject! : string
	private _quizDescription! : string
	private _ver! : number
	private _isActive! : boolean

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get startTime(): string {
        return this._startTime;
    }

    public set startTime(startTime: string) {
        this._startTime = startTime;
    }

    public get endTime(): string {
        return this._endTime;
    }

    public set endTime(endTime: string) {
        this._endTime = endTime;
    }

    public get quizId(): number {
        return this._quizId;
    }

    public set quizId(quizId: number) {
        this._quizId = quizId;
    }

    public get quizCode(): string {
        return this._quizCode;
    }

    public set quizCode(quizCode: string) {
        this._quizCode = quizCode;
    }

    public get quizSubject(): string {
        return this._quizSubject;
    }

    public set quizSubject(quizSubject: string) {
        this._quizSubject = quizSubject;
    }

    public get quizDescription(): string {
        return this._quizDescription;
    }

    public set quizDescription(quizDescription: string) {
        this._quizDescription = quizDescription;
    }

    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

    public get isActive(): boolean {
        return this._isActive;
    }

    public set isActive(isActive: boolean) {
        this._isActive = isActive;
    }
   
}