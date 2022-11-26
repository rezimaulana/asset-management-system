export class LearningMaterialInsertReqDto {

    private learningCode! : string
	private learningSubject! : string
	private learningDescription! : string
	private classId! : number
	private fileCode! : string
	private fileExt! : string

    public get _learningCode(): string {
        return this.learningCode;
    }

    public set _learningCode(_learningCode: string) {
        this.learningCode = _learningCode;
    }

    public get _learningSubject(): string {
        return this.learningSubject;
    }

    public set _learningSubject(_learningSubject: string) {
        this.learningSubject = _learningSubject;
    }

    public get _learningDescription(): string {
        return this.learningDescription;
    }

    public set _learningDescription(_learningDescription: string) {
        this.learningDescription = _learningDescription;
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