package org.cycle_route.back_end.user.web.enums;

public enum Regions {
    SEOUL("SEOUL"),
    BUSAN("BUSAN"),
    DAEGU("DAEGU"),
    INCHEON("INCHEON"),
    GWANGJU("GWANGJU"),
    DAEJEON("DAEJEON"),
    ULSAN("ULSAN"),
    SEJONG("SEJONG"),
    GYEONGGI("GYEONGGI"),
    GANGWON("GANGWON"),
    CHUNGBUK("CHUNGBUK"),
    CHUNGNAM("CHUNGNAM"),
    JEONBUK("JEONBUK"),
    JEONNAM("JEONNAM"),
    GYEONGBUK("GYEONGBUK"),
    GYEONGNAM("GYEONGNAM"),
    JEJU("JEJU");

    private final String region;

    Regions(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
