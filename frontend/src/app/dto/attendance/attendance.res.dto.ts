import { AttendanceDataDto } from "./attendance.data.dto";

export class AttendanceResDto{
    private _data : AttendanceDataDto = new AttendanceDataDto

    public get data(): AttendanceDataDto {
        return this._data;
    }

    public set data(data: AttendanceDataDto) {
        this._data = data;
    }

}