import { LearningScheduleDataDto } from "./learning-schedule.data.dto";

export class LearningScheduleResDto{
    private _data : LearningScheduleDataDto = new LearningScheduleDataDto

    public get data(): LearningScheduleDataDto {
        return this._data;
    }

    public set data(data: LearningScheduleDataDto) {
        this._data = data;
    }

}