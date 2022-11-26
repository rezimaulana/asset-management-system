export class LearningScheduleDataDto{

    private _id! : number
	private _startTime! : string
	private _endTime! : string
	private _learningId! : number
	private _learningCode! : string
	private _learningSubject! : string
	private _learningDescription! : string
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

    public get learningId(): number {
        return this._learningId;
    }

    public set learningId(learningId: number) {
        this._learningId = learningId;
    }

    public get learningCode(): string {
        return this._learningCode;
    }

    public set learningCode(learningCode: string) {
        this._learningCode = learningCode;
    }

    public get learningSubject(): string {
        return this._learningSubject;
    }

    public set learningSubject(learningSubject: string) {
        this._learningSubject = learningSubject;
    }

    public get learningDescription(): string {
        return this._learningDescription;
    }

    public set learningDescription(learningDescription: string) {
        this._learningDescription = learningDescription;
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