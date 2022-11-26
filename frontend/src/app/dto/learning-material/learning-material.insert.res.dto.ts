import { LearningMaterialInsertDataResDto } from "./learning-material.insert.data.res.dto";

export class LearningMaterialInsertResDto{
    private _data! : LearningMaterialInsertDataResDto
	private _message! : string

    public get data(): LearningMaterialInsertDataResDto {
        return this._data;
    }

    public set data(data: LearningMaterialInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}