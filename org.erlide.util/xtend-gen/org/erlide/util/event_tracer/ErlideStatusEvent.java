package org.erlide.util.event_tracer;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.util.event_tracer.ErlideEvent;

@SuppressWarnings("all")
public class ErlideStatusEvent extends ErlideEvent {
  private final Object status;
  
  public ErlideStatusEvent(final Object myStatus) {
    super(new Function0<Long>() {
      public Long apply() {
        long _currentTimeMillis = System.currentTimeMillis();
        return _currentTimeMillis;
      }
    }.apply());
    this.status = myStatus;
  }
  
  public String print() {
    StringConcatenation _builder = new StringConcatenation();
    long _timestamp = this.getTimestamp();
    _builder.append(_timestamp, "");
    _builder.append(" STATUS ");
    String _string = this.status.toString();
    _builder.append(_string, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
