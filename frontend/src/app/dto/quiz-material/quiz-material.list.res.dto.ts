import { QuizMaterialDataDto } from "./quiz-material.data.dto";

export class QuizMaterialListResDto{
    private _data : QuizMaterialDataDto[] = []

    public get data(): QuizMaterialDataDto[] {
        return this._data;
    }

    public set data(data: QuizMaterialDataDto[]) {
        this._data = data;
    }

}