export class ExamCollectionInsertReqDto {
    private classDtlId! : number
	private examScheduleId! : number
	private fileCode! : string
	private fileExt! : string

    public get _classDtlId(): number {
        return this.classDtlId;
    }

    public set _classDtlId(_classDtlId: number) {
        this.classDtlId = _classDtlId;
    }

    public get _examScheduleId(): number {
        return this.examScheduleId;
    }

    public set _examScheduleId(_examScheduleId: number) {
        this.examScheduleId = _examScheduleId;
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