export class ClassHdrDataDto{
    private _id! : number
	private _code! : string
	private _subject! : string
	private _description! : string
	private _fileCode! : string
	private _fileExt! : string
	private _email! : string
	private _fullname! : string
    private _ver! : number
    private _isActive! : boolean
    private _fileId! : number

    public get fileId(): number {
        return this._fileId;
    }

    public set fileId(fileId: number) {
        this._fileId = fileId;
    }

    public get code(): string {
        return this._code;
    }

    public set code(code: string) {
        this._code = code;
    }

    public get subject(): string {
        return this._subject;
    }

    public set subject(subject: string) {
        this._subject = subject;
    }

    public get description(): string {
        return this._description;
    }

    public set description(description: string) {
        this._description = description;
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