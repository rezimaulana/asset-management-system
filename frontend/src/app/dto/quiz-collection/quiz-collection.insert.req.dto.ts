export class QuizCollectionInsertReqDto {
    private classDtlId! : number
	private quizScheduleId! : number
	private fileCode! : string
	private fileExt! : string

    public get _classDtlId(): number {
        return this.classDtlId;
    }

    public set _classDtlId(_classDtlId: number) {
        this.classDtlId = _classDtlId;
    }

    public get _quizScheduleId(): number {
        return this.quizScheduleId;
    }

    public set _quizScheduleId(_quizScheduleId: number) {
        this.quizScheduleId = _quizScheduleId;
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