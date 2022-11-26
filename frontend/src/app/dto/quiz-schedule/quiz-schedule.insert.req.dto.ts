export class QuizScheduleInsertReqDto {

    private startTime! : string
	private endTime! : string
	private quizId! : number

    public get _startTime(): string {
        return this.startTime;
    }

    public set _startTime(_startTime: string) {
        this.startTime = _startTime;
    }

    public get _endTime(): string {
        return this.endTime;
    }

    public set _endTime(_endTime: string) {
        this.endTime = _endTime;
    }

    public get _quizId(): number {
        return this.quizId;
    }

    public set _quizId(_quizId: number) {
        this.quizId = _quizId;
    }

}