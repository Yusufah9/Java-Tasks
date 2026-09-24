
class Things {
    protected String name;

    public Things(String name) {
        this.name = name;
    }
}


class NonLivingThings extends Things {
    public NonLivingThings(String name) {
        super(name);
    }
}

class LivingThings extends Things {
    public LivingThings(String name) {
        super(name);
    }
}

class Plants extends LivingThings {
    protected String type;

    public Plants(String name, String type) {
        super(name);
        this.type = type;
    }
}

class Animals extends LivingThings {
    public Animals(String name) {
        super(name);
    }
}


class Invertebrates extends Animals {
    public Invertebrates(String name) {
        super(name);
    }
}

class Vertebrates extends Animals {
    protected String vertebrateClass; 

    public Vertebrates(String name, String vertebrateClass) {
        super(name);
        this.vertebrateClass = vertebrateClass;
    }
}

