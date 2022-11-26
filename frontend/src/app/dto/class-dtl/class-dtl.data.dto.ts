export class ClassDtlDataDto{
    private _id! : number
	private _classesId! : number
	private _classesCode! : string
	private _classesSubject! : string
    private _classesDescription! : string
	private _instructorId! : number
	private _email! : string
	private _fullname! : string
	private _ver! : number
	private _isActive! : boolean
	private _fileId! : number

    public get classesDescription(): string {
        return this._classesDescription;
    }

    public set classesDescription(classesDescription: string) {
        this._classesDescription = classesDescription;
    }

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get classesId(): number {
        return this._classesId;
    }

    public set classesId(classesId: number) {
        this._classesId = classesId;
    }

    public get classesCode(): string {
        return this._classesCode;
    }

    public set classesCode(classesCode: string) {
        this._classesCode = classesCode;
    }

    public get classesSubject(): string {
        return this._classesSubject;
    }

    public set classesSubject(classesSubject: string) {
        this._classesSubject = classesSubject;
    }

    public get instructorId(): number {
        return this._instructorId;
    }

    public set instructorId(instructorId: number) {
        this._instructorId = instructorId;
    }

    public get email(): string {
        return this._email;
    }

    public set email(email: string) {
        this._email = email;
    }

    public get fullname(): string {
        return this._fullname;
    }

    public set fullname(fullname: string) {
        this._fullname = fullname;
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

    public get fileId(): number {
        return this._fileId;
    }

    public set fileId(fileId: number) {
        this._fileId = fileId;
    }

    


}