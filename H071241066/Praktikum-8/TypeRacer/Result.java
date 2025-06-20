//package TypeRacer;

public class Result {
    private Typer typer;
    private long timeTaken; // in ms

    public Result(Typer typer, long timeTaken) {
        this.typer = typer;
        this.timeTaken = timeTaken;
    }

    public Typer getTyper() {
        return typer;
    }

    public long getTimeTaken() {
        return timeTaken;
    }
}
