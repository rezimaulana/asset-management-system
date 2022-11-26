import { ExamScheduleDataDto } from "./exam-schedule.data.dto";

export class ExamScheduleListResDto{
    private _data : ExamScheduleDataDto[] = []

    public get data(): ExamScheduleDataDto[] {
        return this._data;
    }

    public set data(data: ExamScheduleDataDto[]) {
        this._data = data;
    }

}