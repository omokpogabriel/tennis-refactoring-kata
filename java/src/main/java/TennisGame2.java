
public class TennisGame2 implements TennisGame {
    public int p1point = 0;
    public int p2point = 0;

    public String p1res = "";
    public String p2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (p1point == p2point) {
            if (p1point < 3) {
                score = p1pointEqualsP2pointAndP1pointLTFour(p1point);
            } else {
                score = "Deuce";
            }
        }

        if (p1point > 0 && p2point == 0) {
            p1res = pointGTZeroAndPointEqualsZero(p1point);
            p2res = "Love";
            score = p1res + "-" + p2res;
        }

        if (p2point > 0 && p1point == 0) {
            p2res = pointGTZeroAndPointEqualsZero(p2point);
            p1res = "Love";
            score = p1res + "-" + p2res;
        }

        if (p1point > p2point && p1point < 4) {
            String[] pres = pointGTAndpointLTFour(p1point, p2point);
            p1res = pres[0];
            p2res = pres[1];
            score = p1res + "-" + p2res;
        }
        if ((p2point > p1point) && p2point < 4) {
            String[] pres = pointGTAndpointLTFour(p2point, p1point);
            p2res = pres[0];
            p1res = pres[1];
            score = p1res + "-" + p2res;
        }

        if (p1point > p2point && p2point >= 3) {
            score = "Advantage player1";
        }

        if (p2point > p1point && p1point >= 3) {
            score = "Advantage player2";
        }

        if ((p1point >= 4) && (p2point >= 0) && (p1point - p2point) >= 2) {
            score = "Win for player1";
        }
        if (p2point >= 4 && p1point >= 0 && (p2point - p1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number) {
        for (int i = 0; i < number; i++) {
            p1Score();
        }
    }

    public void SetP2Score(int number) {
        for (int i = 0; i < number; i++) {
            p2Score();
        }
    }

    public void p1Score() {
        p1point++;
    }

    public void p2Score() {
        p2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1") {
            p1Score();
        } else {
            p2Score();
        }
    }

    // the point can only be either 0, 1 or 2, hence the use of return to save execution time
    private String p1pointEqualsP2pointAndP1pointLTFour(int p1point) {
        switch (p1point) {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
//            default: throw new IllegalArgumentException("p1oint value not matched");
        }
        return "-All";
    }

    private String pointGTZeroAndPointEqualsZero(int point) {
        switch (point) {
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
//            default: throw new IllegalArgumentException("p1oint value not matched");
        }
        return "-All";
    }

    private String[] pointGTAndpointLTFour(int p1point, int p2point) {
        String[] pres = new String[2];
        if (p1point == 1)
            pres[0] = "Fifteen";
        if (p1point == 2)
            pres[0] = "Thirty";
        if (p1point == 3)
            pres[0] = "Forty";
        if (p2point == 0)
            pres[1] = "Love";
        if (p2point == 1)
            pres[1] = "Fifteen";
        if (p2point == 2)
            pres[1] = "Thirty";
        return pres;
    }
}