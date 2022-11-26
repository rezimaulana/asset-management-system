export class ClassHdrInsertReqDto {
    private subject! : string
	private description! : string
	private instructorId! : number
    private fileCode! : string
	private fileExt! : string

    public get _subject(): string {
        return this.subject;
    }

    public set _subject(_subject: string) {
        this.subject = _subject;
    }

    public get _description(): string {
        return this.description;
    }

    public set _description(_description: string) {
        this.description = _description;
    }

    public get _instructorId(): number {
        return this.instructorId;
    }

    public set _instructorId(_instructorId: number) {
        this.instructorId = _instructorId;
    }

    public get _fileCode(): string {
        return this.fileCode;
    }

    public set _fileCode(_fileCode: string) {
        this.fileCode = _fileCode;
    }

    public get _fileExt(): string {
        return this.fileExt;
    }

    public set _fileExt(_fileExt: string) {
        this.fileExt = _fileExt;
    }
    
}