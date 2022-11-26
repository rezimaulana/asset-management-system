import { QuizScheduleDataDto } from "./quiz-schedule.data.dto";

export class QuizScheduleListResDto{
    private _data : QuizScheduleDataDto[] = []

    public get data(): QuizScheduleDataDto[] {
        return this._data;
    }

    public set data(data: QuizScheduleDataDto[]) {
        this._data = data;
    }

}