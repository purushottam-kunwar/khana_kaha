package enumconstants

enum Status {

    ACTIVE("Active"), DEACTIVATED("Deactivated"), DELETED("Deleted"), INACTIVE("Inactive");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public static List<Status> getEnumList(Status... statusList) {
        return Arrays.asList(statusList);
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public static List<Status> getStatusList(Status... status) {
        return Arrays.asList(status);
    }


    public static Status getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (Status v : values())
            if (value.equalsIgnoreCase(v.getValue()))
                return v;
        throw new IllegalArgumentException();
    }

}