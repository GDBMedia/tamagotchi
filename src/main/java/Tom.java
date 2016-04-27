import java.util.Timer;
import java.util.TimerTask;

public class Tom {
  private String mName;
  private double mHunger;
  private double mBoredom;
  private double mTiredness;
  private int mFlag;

  public Tom(String name) {
    mName = name;
    mHunger = 99;
    mBoredom = 99;
    mTiredness = 99;
    mFlag = 1;
  }
  public String getName() {
    return mName;
  }
  public double getHunger() {
    return mHunger;
  }
  public double getBoredom() {
    return mBoredom;
  }
  public double getTiredness() {
    return mTiredness;
  }
  public double getFlag() {
    return mFlag;
  }
  public double changeHunger(){
    mBoredom -=2;
    mTiredness -=2;
    mFlag = 2;
    return  mHunger +=1;
  }
  public double changeBoredom(){
    mHunger -=2;
    mTiredness -=2;
    mFlag = 3;
    return  mBoredom +=1;
  }
  public double changeTiredness(){
    mHunger -=2;
    mBoredom -=2;
    mFlag = 4;
    return  mTiredness +=1;
  }
  public boolean checkIsAlive(){
    if(mHunger <= 0 || mBoredom <= 0 || mTiredness <=0){
      return false;
    }
    return true;
  }
}
