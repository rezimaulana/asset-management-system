import { AttendanceInsertDataResDto } from "./attendance.insert.data.res.dto";

export class AttendanceInsertResDto{
    private _data! : AttendanceInsertDataResDto
	private _message! : string

    public get data(): AttendanceInsertDataResDto {
        return this._data;
    }

    public set data(data: AttendanceInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}