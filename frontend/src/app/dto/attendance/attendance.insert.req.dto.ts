export class AttendanceInsertReqDto {
    private classDtlId! : number
	private learningScheduleId! : number
	private quizScheduleId! : number
	private examScheduleId! : number

    public get _classDtlId(): number {
        return this.classDtlId;
    }

    public set _classDtlId(_classDtlId: number) {
        this.classDtlId = _classDtlId;
    }

    public get _learningScheduleId(): number {
        return this.learningScheduleId;
    }

    public set _learningScheduleId(_learningScheduleId: number) {
        this.learningScheduleId = _learningScheduleId;
    }

    public get _quizScheduleId(): number {
        return this.quizScheduleId;
    }

    public set _quizScheduleId(_quizScheduleId: number) {
        this.quizScheduleId = _quizScheduleId;
    }

    public get _examScheduleId(): number {
        return this.examScheduleId;
    }

    public set _examScheduleId(_examScheduleId: number) {
        this.examScheduleId = _examScheduleId;
    }

}