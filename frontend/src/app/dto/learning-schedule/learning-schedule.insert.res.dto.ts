import { LearningScheduleInsertDataResDto } from "./learning-schedule.insert.data.res.dto";

export class LearningScheduleInsertResDto{
    private _data! : LearningScheduleInsertDataResDto
	private _message! : string

    public get data(): LearningScheduleInsertDataResDto {
        return this._data;
    }

    public set data(data: LearningScheduleInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}