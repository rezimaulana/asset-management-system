import { QuizScheduleInsertDataResDto } from "./quiz-schedule.insert.data.res.dto";

export class QuizScheduleInsertResDto{
    private _data! : QuizScheduleInsertDataResDto
	private _message! : string

    public get data(): QuizScheduleInsertDataResDto {
        return this._data;
    }

    public set data(data: QuizScheduleInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}