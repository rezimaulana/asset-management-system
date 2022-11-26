export class AttendanceDataDto{
    private _id! : number
	private _approval! : boolean
	private _classDtlId! : number
	private _studentId! : number
	private _studentEmail! : string
	private _studentFullname! : string
	private _classHdrId! : number
	private _classHdrCode! : string
	private _classHdrSubject! : string
	private _classHdrDescription! : string
	private _instructorId! : number
	private _instructorEmail! : string
	private _instructorFullname! : string
	private _learningScheduleId! : number
	private _learningStartTime! : string
	private _learningEndTime! : string
	private _learningMaterialId! : number
	private _learningCode! : string
	private _learningSubject! : string
	private _learningDescription! : string
	private _quizScheduleId! : number
	private _quizStartTime! : string
	private _quizEndTime! : string
	private _quizMaterialId! : number
	private _quizCode! : string
	private _quizSubject! : string
	private _quizDescription! : string
	private _examScheduleId! : number
	private _examStartTime! : string
	private _examEndTime! : string
	private _examMaterialId! : number
	private _examCode! : string
	private _examSubject! : string
	private _examDescription! : string
	private _ver! : number
    private _isActive! : boolean

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get approval(): boolean {
        return this._approval;
    }

    public set approval(approval: boolean) {
        this._approval = approval;
    }

    public get classDtlId(): number {
        return this._classDtlId;
    }

    public set classDtlId(classDtlId: number) {
        this._classDtlId = classDtlId;
    }

    public get studentId(): number {
        return this._studentId;
    }

    public set studentId(studentId: number) {
        this._studentId = studentId;
    }

    public get studentEmail(): string {
        return this._studentEmail;
    }

    public set studentEmail(studentEmail: string) {
        this._studentEmail = studentEmail;
    }

    public get studentFullname(): string {
        return this._studentFullname;
    }

    public set studentFullname(studentFullname: string) {
        this._studentFullname = studentFullname;
    }

    public get classHdrId(): number {
        return this._classHdrId;
    }

    public set classHdrId(classHdrId: number) {
        this._classHdrId = classHdrId;
    }

    public get classHdrCode(): string {
        return this._classHdrCode;
    }

    public set classHdrCode(classHdrCode: string) {
        this._classHdrCode = classHdrCode;
    }

    public get classHdrSubject(): string {
        return this._classHdrSubject;
    }

    public set classHdrSubject(classHdrSubject: string) {
        this._classHdrSubject = classHdrSubject;
    }

    public get classHdrDescription(): string {
        return this._classHdrDescription;
    }

    public set classHdrDescription(classHdrDescription: string) {
        this._classHdrDescription = classHdrDescription;
    }

    public get instructorId(): number {
        return this._instructorId;
    }

    public set instructorId(instructorId: number) {
        this._instructorId = instructorId;
    }

    public get instructorEmail(): string {
        return this._instructorEmail;
    }

    public set instructorEmail(instructorEmail: string) {
        this._instructorEmail = instructorEmail;
    }

    public get instructorFullname(): string {
        return this._instructorFullname;
    }

    public set instructorFullname(instructorFullname: string) {
        this._instructorFullname = instructorFullname;
    }

    public get learningScheduleId(): number {
        return this._learningScheduleId;
    }

    public set learningScheduleId(learningScheduleId: number) {
        this._learningScheduleId = learningScheduleId;
    }

    public get learningStartTime(): string {
        return this._learningStartTime;
    }

    public set learningStartTime(learningStartTime: string) {
        this._learningStartTime = learningStartTime;
    }

    public get learningEndTime(): string {
        return this._learningEndTime;
    }

    public set learningEndTime(learningEndTime: string) {
        this._learningEndTime = learningEndTime;
    }

    public get learningMaterialId(): number {
        return this._learningMaterialId;
    }

    public set learningMaterialId(learningMaterialId: number) {
        this._learningMaterialId = learningMaterialId;
    }

    public get learningCode(): string {
        return this._learningCode;
    }

    public set learningCode(learningCode: string) {
        this._learningCode = learningCode;
    }

    public get learningSubject(): string {
        return this._learningSubject;
    }

    public set learningSubject(learningSubject: string) {
        this._learningSubject = learningSubject;
    }

    public get learningDescription(): string {
        return this._learningDescription;
    }

    public set learningDescription(learningDescription: string) {
        this._learningDescription = learningDescription;
    }

    public get quizScheduleId(): number {
        return this._quizScheduleId;
    }

    public set quizScheduleId(quizScheduleId: number) {
        this._quizScheduleId = quizScheduleId;
    }

    public get quizStartTime(): string {
        return this._quizStartTime;
    }

    public set quizStartTime(quizStartTime: string) {
        this._quizStartTime = quizStartTime;
    }

    public get quizEndTime(): string {
        return this._quizEndTime;
    }

    public set quizEndTime(quizEndTime: string) {
        this._quizEndTime = quizEndTime;
    }

    public get quizMaterialId(): number {
        return this._quizMaterialId;
    }

    public set quizMaterialId(quizMaterialId: number) {
        this._quizMaterialId = quizMaterialId;
    }

    public get quizCode(): string {
        return this._quizCode;
    }

    public set quizCode(quizCode: string) {
        this._quizCode = quizCode;
    }

    public get quizSubject(): string {
        return this._quizSubject;
    }

    public set quizSubject(quizSubject: string) {
        this._quizSubject = quizSubject;
    }

    public get quizDescription(): string {
        return this._quizDescription;
    }

    public set quizDescription(quizDescription: string) {
        this._quizDescription = quizDescription;
    }

    public get examScheduleId(): number {
        return this._examScheduleId;
    }

    public set examScheduleId(examScheduleId: number) {
        this._examScheduleId = examScheduleId;
    }

    public get examStartTime(): string {
        return this._examStartTime;
    }

    public set examStartTime(examStartTime: string) {
        this._examStartTime = examStartTime;
    }

    public get examEndTime(): string {
        return this._examEndTime;
    }

    public set examEndTime(examEndTime: string) {
        this._examEndTime = examEndTime;
    }

    public get examMaterialId(): number {
        return this._examMaterialId;
    }

    public set examMaterialId(examMaterialId: number) {
        this._examMaterialId = examMaterialId;
    }

    public get examCode(): string {
        return this._examCode;
    }

    public set examCode(examCode: string) {
        this._examCode = examCode;
    }

    public get examSubject(): string {
        return this._examSubject;
    }

    public set examSubject(examSubject: string) {
        this._examSubject = examSubject;
    }

    public get examDescription(): string {
        return this._examDescription;
    }

    public set examDescription(examDescription: string) {
        this._examDescription = examDescription;
    }

    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

    public get isActive(): boolean {
        return this._isActive;
    }

    public set isActive(isActive: boolean) {
        this._isActive = isActive;
    }

}