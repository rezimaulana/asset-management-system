import { QuizCollectionDataDto } from "./quiz-collection.data.dto";

export class QuizCollectionListResDto{
    private _data : QuizCollectionDataDto[] = []

    public get data(): QuizCollectionDataDto[] {
        return this._data;
    }

    public set data(data: QuizCollectionDataDto[]) {
        this._data = data;
    }

}