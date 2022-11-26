import { AttendanceUpdateDataResDto } from "./attendance.update.data.res.dto";

export class AttendanceUpdateResDto{
    private _data! : AttendanceUpdateDataResDto
	private _message! : string

    public get data(): AttendanceUpdateDataResDto {
        return this._data;
    }

    public set data(data: AttendanceUpdateDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }
    
}