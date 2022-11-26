export class ExamMaterialInsertReqDto {

    private examCode! : string
	private examSubject! : string
	private examDescription! : string
	private classId! : number
	private fileCode! : string
	private fileExt! : string

    public get _examCode(): string {
        return this.examCode;
    }

    public set _examCode(_examCode: string) {
        this.examCode = _examCode;
    }

    public get _examSubject(): string {
        return this.examSubject;
    }

    public set _examSubject(_examSubject: string) {
        this.examSubject = _examSubject;
    }

    public get _examDescription(): string {
        return this.examDescription;
    }

    public set _examDescription(_examDescription: string) {
        this.examDescription = _examDescription;
    }

    public get _classId(): number {
        return this.classId;
    }

    public set _classId(_classId: number) {
        this.classId = _classId;
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