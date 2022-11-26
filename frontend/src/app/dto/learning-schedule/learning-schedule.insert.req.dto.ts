export class LearningScheduleInsertReqDto {

    private startTime! : string
	private endTime! : string
	private learningId! : number

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

    public get _learningId(): number {
        return this.learningId;
    }

    public set _learningId(_learningId: number) {
        this.learningId = _learningId;
    }

}