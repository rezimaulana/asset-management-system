import { QuizScheduleDataDto } from "./quiz-schedule.data.dto";

export class QuizScheduleResDto{
    private _data : QuizScheduleDataDto = new QuizScheduleDataDto

    public get data(): QuizScheduleDataDto {
        return this._data;
    }

    public set data(data: QuizScheduleDataDto) {
        this._data = data;
    }

}