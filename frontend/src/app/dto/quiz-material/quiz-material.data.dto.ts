export class QuizMaterialDataDto{

    private _id! : number
	private _quizCode! : string
	private _quizSubject! : string
	private _quizDescription! : string
	private _classId! : number
	private _classCode! : string
	private _classSubject! : string
	private _fileId! : number
	private _fileCode! : string
	private _fileExt! : string
	private _ver! : number
    private _isActive! : boolean 
    private _fileList! : number[]
    private _createdAt! : string

    public get createdAt(): string {
        return this._createdAt;
    }

    public set createdAt(createdAt: string) {
        this._createdAt = createdAt;
    }

    public get isActive(): boolean {
        return this._isActive;
    }

    public set isActive(isActive: boolean) {
        this._isActive = isActive;
    }

    public get fileList(): number[] {
        return this._fileList;
    }

    public set fileList(fileList: number[]) {
        this._fileList = fileList;
    }

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
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

    public get classId(): number {
        return this._classId;
    }

    public set classId(classId: number) {
        this._classId = classId;
    }

    public get classCode(): string {
        return this._classCode;
    }

    public set classCode(classCode: string) {
        this._classCode = classCode;
    }

    public get classSubject(): string {
        return this._classSubject;
    }

    public set classSubject(classSubject: string) {
        this._classSubject = classSubject;
    }

    public get fileId(): number {
        return this._fileId;
    }

    public set fileId(fileId: number) {
        this._fileId = fileId;
    }

    public get fileCode(): string {
        return this._fileCode;
    }

    public set fileCode(fileCode: string) {
        this._fileCode = fileCode;
    }

    public get fileExt(): string {
        return this._fileExt;
    }

    public set fileExt(fileExt: string) {
        this._fileExt = fileExt;
    }

    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

}