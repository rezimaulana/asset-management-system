import { ExamCollectionDataDto } from "./exam-collection.data.dto";

export class ExamCollectionListResDto{
    private _data : ExamCollectionDataDto[] = []

    public get data(): ExamCollectionDataDto[] {
        return this._data;
    }

    public set data(data: ExamCollectionDataDto[]) {
        this._data = data;
    }

}