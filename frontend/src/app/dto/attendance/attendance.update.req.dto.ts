export class AttendanceUpdateReqDto {
    private id! : number
    private approval! : boolean
    private ver! : number

    public get _approval(): boolean {
        return this.approval;
    }

    public set _approval(_approval: boolean) {
        this.approval = _approval;
    }

    public get _id(): number {
        return this.id;
    }

    public set _id(_id: number) {
        this.id = _id;
    }

    public get _ver(): number {
        return this.ver;
    }

    public set _ver(_ver: number) {
        this.ver = _ver;
    }
    
}