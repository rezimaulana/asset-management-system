export class ExamCollectionDataDto{
    private _id! : number
	private _score! : number
	private _studentEmail! : string
	private _studentName! : string
	private _fileId! : number
    private _ver! : number
    private _isActive! : boolean
    
    public get score(): number {
        return this._score;
    }

    public set score(score: number) {
        this._score = score;
    }

    public get studentEmail(): string {
        return this._studentEmail;
    }

    public set studentEmail(studentEmail: string) {
        this._studentEmail = studentEmail;
    }

    public get studentName(): string {
        return this._studentName;
    }

    public set studentName(studentName: string) {
        this._studentName = studentName;
    }

    public get fileId(): number {
        return this._fileId;
    }

    public set fileId(fileId: number) {
        this._fileId = fileId;
    }

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
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