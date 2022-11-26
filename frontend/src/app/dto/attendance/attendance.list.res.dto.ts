import { AttendanceDataDto } from "./attendance.data.dto";

export class AttendanceListResDto{
    private _data : AttendanceDataDto[] = []

    public get data(): AttendanceDataDto[] {
        return this._data;
    }

    public set data(data: AttendanceDataDto[]) {
        this._data = data;
    }

}