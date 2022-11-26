import { ExamScheduleInsertDataResDto } from "./exam-schedule.insert.data.res.dto";

export class ExamScheduleInsertResDto{
    private _data! : ExamScheduleInsertDataResDto
	private _message! : string

    public get data(): ExamScheduleInsertDataResDto {
        return this._data;
    }

    public set data(data: ExamScheduleInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}