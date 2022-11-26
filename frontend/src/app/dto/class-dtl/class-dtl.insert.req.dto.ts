export class ClassDtlInsertReqDto {
    private studentId! : number
	private classesId! : number

    public get _studentId(): number {
        return this.studentId;
    }

    public set _studentId(_studentId: number) {
        this.studentId = _studentId;
    }

    public get _classesId(): number {
        return this.classesId;
    }

    public set _classesId(_classesId: number) {
        this.classesId = _classesId;
    }

}