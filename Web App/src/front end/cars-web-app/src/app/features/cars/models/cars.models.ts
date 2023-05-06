export interface CarDTO{
    carID:number;
    carManufacturer:string;
    carModel:string;
    carRetailPrice:number;
    carTopSpeed:number;
    carWeight:number;
    dealershipID:number;
}

export interface CarAddDTO{
    carManufacturer:string;
    carModel:string;
    carRetailPrice:number;
    carTopSpeed:number;
    carWeight:number;
}

export interface CarNoIDDTO{
    carManufacturer:string;
    carModel:string;
    carRetailPrice:number;
    carTopSpeed:number;
    carWeight:number;
}