export class ExamScheduleDataDto{

    private _id! : number
	private _startTime! : string
	private _endTime! : string
	private _examId! : number
	private _examCode! : string
	private _examSubject! : string
	private _examDescription! : string
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

    public get examId(): number {
        return this._examId;
    }

    public set examId(examId: number) {
        this._examId = examId;
    }

    public get examCode(): string {
        return this._examCode;
    }

    public set examCode(examCode: string) {
        this._examCode = examCode;
    }

    public get examSubject(): string {
        return this._examSubject;
    }

    public set examSubject(examSubject: string) {
        this._examSubject = examSubject;
    }

    public get examDescription(): string {
        return this._examDescription;
    }

    public set examDescription(examDescription: string) {
        this._examDescription = examDescription;
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