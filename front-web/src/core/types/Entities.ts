export type ProductsResponse = {
    content: Product[];
    totalPages: number;
}

export type FeedstocksResponse = {
    content: Feedstock[];
    totalPages: number;
}

export type Product = {
    id: number;
    name: string;
    price: number;
}

export type Feedstock = {
     id: number;
     name: string;
     amount: number;
     type: string;
}

export type AmountFeedstocks = {
    feedstock: Feedstock;
    amount: number;
}