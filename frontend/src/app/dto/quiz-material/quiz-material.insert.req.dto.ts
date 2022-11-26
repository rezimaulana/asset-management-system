export class QuizMaterialInsertReqDto {

    private quizCode! : string
	private quizSubject! : string
	private quizDescription! : string
	private classId! : number
	private fileCode! : string
	private fileExt! : string

    public get _quizCode(): string {
        return this.quizCode;
    }

    public set _quizCode(_quizCode: string) {
        this.quizCode = _quizCode;
    }

    public get _quizSubject(): string {
        return this.quizSubject;
    }

    public set _quizSubject(_quizSubject: string) {
        this.quizSubject = _quizSubject;
    }

    public get _quizDescription(): string {
        return this.quizDescription;
    }

    public set _quizDescription(_quizDescription: string) {
        this.quizDescription = _quizDescription;
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