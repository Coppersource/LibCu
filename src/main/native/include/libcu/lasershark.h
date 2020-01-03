#include <frc/DigitalSource.h>
#include <frc/DutyCycle.h>
#include <frc/smartdashboard/Sendable.h>
#include <frc/smartdashboard/SendableHelper.h>
#include <units/units.h>

namespace libcu
{
class Lasershark : public frc::Sendable, 
                   public frc::SendableHelper<Lasershark>
{
public:
    explicit Lasershark(int input);
    explicit Lasershark(frc::DigitalSource &source);
    explicit Lasershark(frc::DigitalSource *source);
    explicit Lasershark(std::shared_ptr<frc::DigitalSource> source);
    
    Lasershark(Lasershark&&) = default;
    Lasershark& operator=(Lasershark&&) = default;

    units::meter_t GetDistance();
    
protected:
    void InitSendable(frc::SendableBuilder& builder) override;

private:
    frc::DutyCycle pwmInput;
};
} // namespace libcu
