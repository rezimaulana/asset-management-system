import { LearningMaterialDataDto } from "./learning-material.data.dto";

export class LearningMaterialListResDto{
    private _data : LearningMaterialDataDto[] = []

    public get data(): LearningMaterialDataDto[] {
        return this._data;
    }

    public set data(data: LearningMaterialDataDto[]) {
        this._data = data;
    }

}