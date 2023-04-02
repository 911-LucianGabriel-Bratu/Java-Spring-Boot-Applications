export interface Dealerships {
    id: number;
    name: string;
    capacity: number;
    address: string;
    reputation: number;
    hasService: boolean;
    offersTradeIn:boolean;
}

export interface DealershipsDTO {
    name: string;
    capacity: number;
    address: string;
    reputation: number;
    hasService: boolean;
    offersTradeIn:boolean;
}

