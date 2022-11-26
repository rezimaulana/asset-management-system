import { QuizCollectionDataDto } from "./quiz-collection.data.dto";

export class QuizCollectionResDto{
    private _data : QuizCollectionDataDto = new QuizCollectionDataDto

    public get data(): QuizCollectionDataDto {
        return this._data;
    }

    public set data(data: QuizCollectionDataDto) {
        this._data = data;
    }

}