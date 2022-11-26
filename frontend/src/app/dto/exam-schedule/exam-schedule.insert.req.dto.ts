export class ExamScheduleInsertReqDto {

    private startTime! : string
	private endTime! : string
	private examId! : number

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

    public get _examId(): number {
        return this.examId;
    }

    public set _examId(_examId: number) {
        this.examId = _examId;
    }

}