import { LearningScheduleDataDto } from "./learning-schedule.data.dto";

export class LearningScheduleListResDto{
    private _data : LearningScheduleDataDto[] = []

    public get data(): LearningScheduleDataDto[] {
        return this._data;
    }

    public set data(data: LearningScheduleDataDto[]) {
        this._data = data;
    }

}