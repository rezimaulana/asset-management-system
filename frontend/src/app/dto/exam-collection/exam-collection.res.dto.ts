import { ExamCollectionDataDto } from "./exam-collection.data.dto";

export class ExamCollectionResDto{
    private _data : ExamCollectionDataDto = new ExamCollectionDataDto

    public get data(): ExamCollectionDataDto {
        return this._data;
    }

    public set data(data: ExamCollectionDataDto) {
        this._data = data;
    }

}